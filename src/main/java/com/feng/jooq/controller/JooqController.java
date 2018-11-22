package com.feng.jooq.controller;

import com.feng.jooq.representation.Author;
import com.feng.jooq.representation.BookDetails;
import com.feng.jooq.service.JooqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Api(description = "用户&书籍接口")
@RestController
@RequiredArgsConstructor
public class JooqController {

    private final JooqService jooqService;

    @ApiOperation(value = "查询所有作者" ,  notes="查询所有作者")
    @GetMapping("/getAuthors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAuthors(){
        return jooqService.getAuthors();
    }

    @ApiOperation(value = "创建作者" ,  notes="创建作者")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firstName", value = "firstName", required = true, dataType = "authorCommand"),
            @ApiImplicitParam(name = "lastName", value = "lastName", required = true, dataType = "authorCommand"),
            @ApiImplicitParam(name = "address", value = "地址", required = true, dataType = "authorCommand"),
            @ApiImplicitParam(name = "dateOfBirthDay", value = "出生日期", required = true, dataType = "authorCommand")
    })
    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addAuthor(@RequestBody AuthorCommand authorCommand){
        return jooqService.addAuthor(authorCommand.getFirstName(),
                authorCommand.getLastName(),
                authorCommand.getAddress(),
                authorCommand.getDateOfBirthDay());
    }

    @ApiOperation(value = "修改作者信息" ,  notes="修改作者信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "firstName", value = "firstName", required = true, dataType = "AuthorCommand"),
            @ApiImplicitParam(name = "lastName", value = "lastName", required = true, dataType = "AuthorCommand"),
            @ApiImplicitParam(name = "address", value = "地址", required = true, dataType = "AuthorCommand"),
            @ApiImplicitParam(name = "dateOfBirthDay", value = "出生日期", required = true, dataType = "AuthorCommand")
    })
    @PutMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@PathVariable Integer id,
                             @RequestBody AuthorCommand authorCommand){
        jooqService.updateAuthor(id,
                authorCommand.getFirstName(),
                authorCommand.getLastName(),
                authorCommand.getAddress(),
                authorCommand.getDateOfBirthDay());
    }

    @ApiOperation(value = "删除作者" ,  notes="删除作者")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Integer id){
        jooqService.deleteAuthor(id);
    }

    @ApiOperation(value = "查询所有作者以及书籍信息" ,  notes="查询所有作者以及书籍信息")
    @GetMapping("/bookDetails")
    @ResponseStatus(HttpStatus.OK)
    public Page<BookDetails> bookDetails(Pageable pageable){
        return jooqService.bookDetails(pageable);
    }

    @Data
    public static class AuthorCommand{
        private String firstName;
        private String lastName;
        private String address;
        private LocalDate dateOfBirthDay;
    }

}
