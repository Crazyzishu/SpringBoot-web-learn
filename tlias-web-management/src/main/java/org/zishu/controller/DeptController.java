package org.zishu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zishu.pojo.Dept;
import org.zishu.pojo.Result;
import org.zishu.service.DeptService;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //指定访问路径，指定请求的方法
    //@RequestMapping(value ="/depts" ,method = RequestMethod.GET)
    @GetMapping("/depts")//直接指定请求方式为GET
    public Result list(){
        System.out.println("查询全部的部门数据");
        List<Dept> deptList =  deptService.findAll();
        return Result.success(deptList);
    }
    /**
     * 删除部门 - 方式一：HttpServletRequest 获取请求参数
     */
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("根据id删除部门："+ id);
//        return Result.success();
//    }

    /**
     * 删除部门 - 方式二：@RequestParam
     * 注意事项：一旦声明了@RequestParam注解，那么请求参数中必须要传递，否则会报错（默认，require 为 true）
     */
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(value = "id",required = false) Integer deptId){
//        System.out.println("根据id删除部门："+ deptId);
//        return Result.success();
//    }

    /**
     * 删除部门 - 方式三：省略@RequestParam注解（前端传递的参数名与服务端方法形参名一致）[推荐]
     */
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("根据id删除部门："+ id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门："+ dept);
        deptService.add(dept);
        return Result.success();
    }
}
