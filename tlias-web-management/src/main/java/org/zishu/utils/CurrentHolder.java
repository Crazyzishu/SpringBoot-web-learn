package org.zishu.utils;

// 定义 CurrentHolder 类
public class CurrentHolder {

    // 使用 ThreadLocal 存储当前线程的员工 ID，确保线程间数据隔离
    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    // 设置当前线程的员工 ID
    public static void setCurrentId(Integer employeeId) {
        CURRENT_LOCAL.set(employeeId);
    }

    // 获取当前线程的员工 ID
    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();
    }

    // 移除当前线程的员工 ID，避免内存泄漏
    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}