# 1. 导入坐标
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.datatype</groupId>
            <artifactId>jackson-datatype-jsr310</artifactId>
        </dependency>
```
# 2. properties配置文件
# redis 连接
spring.data.redis.host=127.0.0.1
spring.data.redis.port=6379
spring.data.redis.password=123456
spring.data.redis.database=0
spring.data.redis.lettuce.pool.max-active=8
spring.data.redis.lettuce.pool.max-idle=8
spring.data.redis.lettuce.pool.min-idle=0

# 3. 配置类
```java
@Configuration
// 开启SpringCache缓存功能
@EnableCaching
public class RedisConfig {

    /**
     * 配置RedisTemplate
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(@Autowired RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 配置 ObjectMapper 支持 Java 8 时间类型
        ObjectMapper objectMapper = createObjectMapper();
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 配置SpringCache 缓存为redis
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(@Autowired RedisConnectionFactory factory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();

        // 配置 ObjectMapper 支持 Java 8 时间类型
        ObjectMapper objectMapper = createObjectMapper();

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);

        // 配置序列化
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)) // 设置缓存有效期1小时
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues(); // 不缓存空值

        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .build();
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.registerModule(new JavaTimeModule()); // 添加 JavaTime 模块支持
        return mapper;
    }

}
```
# 4. 使用
创建 cache文件夹，创建缓存调用类 CacheData
```java
@Slf4j
@Component
// CacheConfig 是key的前缀
@CacheConfig(cacheNames = "ads")
public class CacheData {

    @Resource
    AdsClient adsClient;
    
    // Cacheable是key的名称，#root.methodName是方法名
    @Cacheable(key = "#root.methodName")
    public List<BmgCarousel> getCarouselList() {
        log.info("从数据库中获取轮播图数据 - 缓存未命中");
        List<BmgCarousel> result = adsClient.getCarouselList();
        log.info("获取到 {} 条轮播图数据", result != null ? result.size() : 0);
        return result;
    }
}

```