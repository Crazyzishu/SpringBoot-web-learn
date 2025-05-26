package org.zishu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zishu.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量保存员工工作经历信息
     */
    void insertBatch(List<EmpExpr> exprList);
}
