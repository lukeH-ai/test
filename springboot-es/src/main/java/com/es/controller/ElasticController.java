package com.es.controller;

import com.es.model.DocBean;
import com.es.service.IElasticService;
import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/elastic")
public class ElasticController {

    @Autowired
    private IElasticService elasticService;

    @GetMapping("/init")
    public void init() {
        elasticService.createIndex();
        List<DocBean> list = new ArrayList<>();
        list.add(new DocBean(1L, "XX0193", "XX8064", "1111111", 1));
        list.add(new DocBean(2L, "XX0210", "XX7475", "2222222", 1));
        list.add(new DocBean(3L, "XX0257", "XX8097", "3333333", 1));
        for (int i = 1; i < 1000; i++) {
            list.add(new DocBean((long) i, "xxx" + i, "yyy" + i, "插入第" + i + "个内容", i));
        }
        elasticService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<DocBean> all() {
        return elasticService.findAll();
    }

    @GetMapping("/update/{id}/{content}")
    public DocBean update(@PathVariable("id") Long id, @PathVariable("content") String content) {
        //elasticService.save(new DocBean(id,"XX0193","XX8064",content,1));
        DocBean docBean = new DocBean();
        docBean.setId(id);
//        docBean.setFirstCode("XX0193");
//        docBean.setSecordCode("XX8064");
        docBean.setContent(content);
//        docBean.setType(1);
        return elasticService.update(docBean);
    }

    @GetMapping("/update2/{content}")
    public Iterator<DocBean> update2(@PathVariable("content") String content) {
        Iterator<DocBean> docBeans = elasticService.findAll();
        while (docBeans.hasNext()) {
            DocBean docBean = (DocBean) docBeans.next();
            docBean.setContent(docBean.getContent() + content);
            elasticService.update(docBean);
        }
        return elasticService.findAll();
    }

    @GetMapping("/delete")
    public String delete() {
        Iterable<DocBean> docBeans = elasticService.findAllObj();
        elasticService.deleteByList(docBeans);
        List<DocBean> beans = Lists.newArrayList(elasticService.findAll());
        return beans.size() == 0 ? "删除成功" : "删除失败";
    }

}
