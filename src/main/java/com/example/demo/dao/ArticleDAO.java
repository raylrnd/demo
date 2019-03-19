package com.example.demo.dao;
import com.example.demo.model.ArticleDomain;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDAO {
    String TABLE_NAME = " Article";
    String SELECT_FIELDS = " content,writeTime,likeCount,commentCount,title,type1,type2,type3";
    String BASIC_FIELDS = "  content,writeTime,title,type1,type2,type3,slug";
    String UPDATE_FIELDS = " articleId, content,title,type1,type2,type3";

    @Insert({"insert into",TABLE_NAME,"(",BASIC_FIELDS,")values (#{content},#{writeTime}" +
            ",#{title},#{type1},#{type2},#{type3},#{slug})"})
    int addArticle(ArticleDomain articleDomain);


    @Select({"select ", UPDATE_FIELDS, " from ", TABLE_NAME,
            " where articleId=#{articleId}"})
    ArticleDomain selectById(@Param("articleId") int articleId);



    @Update({"update ",TABLE_NAME,"set title = #{title} , type1 = #{type1}, type2 = #{type2}," +
            "type3 = #{type3} , content = #{content}, slug = #{slug} where articleId = #{articleId}"})
    int updateArticle(ArticleDomain articleDomain);

    @Select("select * from Article")
    List<ArticleDomain> listALL();
}
