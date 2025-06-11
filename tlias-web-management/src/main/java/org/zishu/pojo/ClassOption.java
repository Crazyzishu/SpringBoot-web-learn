package org.zishu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassOption {
    private List clazzList;//班级列表
    private List dataList;//数据列表
}
