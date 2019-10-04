package com.music.tuna.musicboard.dao;

import com.music.tuna.musicboard.vo.MusicBoardArticle;
import com.music.tuna.util.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MusicBoardArticleDAO {
    SqlSession sqlSession;
    public MusicBoardArticleDAO(){
        this.sqlSession = SqlSessionFactoryBean.getSqlSessionInstance();
    }
    public void insertArticle(MusicBoardArticle vo){
        sqlSession.insert("MusicBoardArticleDAO.insertArticle", vo);
    }
    public MusicBoardArticle lastInsertedArticle(){
        return (MusicBoardArticle)sqlSession.selectOne("MusicBoardArticleDAO.lastInsertedArticle");
    }
    public MusicBoardArticle getArticle(MusicBoardArticle vo){
        return sqlSession.selectOne("MusicBoardArticleDAO.selectArticleByArticleNo", vo);
    }
    public void commit(){
        sqlSession.commit();
    }
}
