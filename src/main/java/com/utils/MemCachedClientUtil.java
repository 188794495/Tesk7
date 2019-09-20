//package com.utils;
//
//
//import com.pojo.User;
//import com.whalin.MemCached.MemCachedClient;
//import com.whalin.MemCached.SockIOPool;
//
//import java.util.List;
//
///**
// * @author Administrator
// */
//public class MemCachedClientUtil {
//    private static MemCachedClient memCachedClient =new MemCachedClient();
//    /**
//     * 服务器ip:port
//     */
//
//    private static String[] servers = { "127.0.0.1:11211" };
//
//    static {
//        memCachedClient = new MemCachedClient();
//        SockIOPool pool = SockIOPool.getInstance();
//        pool.setServers(servers);
//        pool.setWeights(new Integer[] { 3 });
//        pool.setInitConn(5);
//        pool.setMinConn(5);
//        pool.setMaxConn(200);
//        pool.setMaxIdle(1000 * 30 * 30);
//        pool.setMaintSleep(30);
//        pool.setNagle(false);
//        pool.setSocketConnectTO(30);
//        pool.initialize();
//    }
//
//    /**
//     * 增
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean add(String key, Object value) {
//        return memCachedClient.add(key, value);
//    }
//
//    /**
//     * 删
//     * @param key
//     * @return
//     */
//    public boolean delete(String key) {
//        return memCachedClient.delete(key);
//    }
//
//    /**
//     * 改
//     * @param key
//     * @param users
//     * @param value
//     * @return
//     */
//    public static boolean set(String key, List<User> users, Object value) {
//        return memCachedClient.set(key, value);
//    }
//
//    /**
//     * 改
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean replace(String key, Object value) {
//        return memCachedClient.replace(key, value);
//    }
//
//    /**
//     * 查
//     * @param key
//     * @return
//     */
//    public static Object get(String key) {
//        return memCachedClient.get(key);
//    }
//
//}
