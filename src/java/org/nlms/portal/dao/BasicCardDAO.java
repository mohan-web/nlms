package org.nlms.portal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.nlms.portal.model.BasicBenificiary;
import org.nlms.portal.model.BasicCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasicCardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BasicCardDAO.class);
	
	@Autowired
    private SqlSessionFactory sqlSessionFactory;
	
	public List<BasicCard> getByMandal(BasicCard basicCard){
		Map<String, Object> params = new HashMap<>();
        params.put("p", basicCard);
        SqlSession sqlSession = null;
        List<BasicCard> list;
        try{
        	sqlSession = sqlSessionFactory.openSession();
            list = sqlSession.selectList("Basic.GetByMandal", params);
        }finally{
        	sqlSession.close();
        }
                
        return list;
	}

	public BasicBenificiary getByBenificiary(BasicCard basicCard) {
		Map<String, Object> params = new HashMap<>();
        params.put("p", basicCard);
        SqlSession sqlSession = null;
        BasicBenificiary basicBenificiary;
        try{
        	sqlSession = sqlSessionFactory.openSession();
            basicBenificiary = sqlSession.selectOne("Basic.GetBenificiaryByaadhaar", params);
        }finally{
        	sqlSession.close();
        }

		return basicBenificiary;
	}
}
