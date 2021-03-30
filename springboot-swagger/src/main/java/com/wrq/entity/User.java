package com.wrq.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weiruiqi
 * @date 2021/3/30 23:57
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户实体")
public class User {

    @ApiModelProperty("用户编号")
    private Long id;

    @ApiModelProperty("用户姓名")
    private String name;


    @ApiModelProperty("用户年龄")
    private Integer age;
}
