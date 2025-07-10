package org.zishu.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zishu.anno.Log;
import org.zishu.pojo.Dept;
import org.zishu.pojo.Result;
import org.zishu.service.DeptService;
import org.zishu.service.ReportService;

import java.util.List;

/**
 * 部门管理
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);//固定的

    @Autowired
    private DeptService deptService;

    //指定访问路径，指定请求的方法
    //@RequestMapping(value ="/depts" ,method = RequestMethod.GET)
    @GetMapping//直接指定请求方式为GET
    public Result list(){
        log.info("查询所有部门信息");
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
    @Log
    @DeleteMapping
    public Result delete(Integer id){
//        System.out.println("根据id删除部门："+ id);
        log.info("根据id删除部门：{}",id);

        //1.检查部门下是否有员工
        int empCount = deptService.getCountEmpByDeptId(id);
        if(empCount > 0){
            return Result.error("对不起，当前部门下有员工，不能直接删除!");
        }
        //2.删除部门
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
//        System.out.println("新增部门："+ dept);
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     *根据ID查询部门
     */
    @GetMapping("{id}")
    public Result getInfo(@PathVariable Integer id){
//        System.out.println("根据id查询部门："+ id);
        log.info("根据id查询部门：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 修改部门
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){//@RequestBody将前台发送的json数据转为java对象
//        System.out.println("修改部门："+ dept);
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
