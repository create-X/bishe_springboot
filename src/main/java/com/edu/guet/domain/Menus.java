package com.edu.guet.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("MENUS")
public class Menus implements Serializable {

    private String id;
    private String pId;
    private String name;
    private String icon;
    private String url;

    private Menus parentMenu;
    private List<Menus> childMenus=new ArrayList<>();


}
