package org.zishu.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperateLogQueryParam {
    private Integer page;//页码
    private Integer pageSize;//每页显示的记录数
//    private Integer id;//操作人ID
//    private String clazzName;//被操作的类名
//    private String methodName;//操作的方法名
//    private String methodParams;//请求参数
//    private String ReturnName;//返回值
//    private Long costTime;//操作耗时
    private String operateEmpName;//操作人姓名
}
