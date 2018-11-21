package com.feng.jooq.controller;

import com.feng.jooq.representation.Author;
import com.feng.jooq.representation.BookDetails;
import com.feng.jooq.service.JooqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "用户&书籍接口")
@RestController
@RequiredArgsConstructor
public class JooqController {

    private final JooqService jooqService;

    @ApiOperation(value = "查询所有作者" ,  notes="查询所有作者")
    @GetMapping("/getAuthor")
    public List<Author> getAuthors(){
        return jooqService.getAuthors();
    }

    @ApiOperation(value = "查询所有作者以及书籍信息" ,  notes="查询所有作者以及书籍信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = false ,dataType = "int"),
            @ApiImplicitParam(name = "size", value = "页大小", required = false ,dataType = "int")
    })
    @GetMapping("/book-details")
    public Page<BookDetails> bookDetails(Pageable pageable){
        return jooqService.bookDetails(pageable);
    }

}
