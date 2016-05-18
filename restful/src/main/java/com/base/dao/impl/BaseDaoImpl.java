package com.base.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.base.dao.BaseDao;

public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {
	
	
		@Autowired
		private SqlSessionTemplate sqlSessionTemplate;
		public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
			super.setSqlSessionFactory(sqlSessionFactory);
		}

		public void insert(String statementName, Object record) {
			sqlSessionTemplate.insert(statementName, record);
		}

		public int update(String statementName, Object record) {
			return sqlSessionTemplate.update(statementName, record);
		}

		public Object selectByPrimaryKey(String statementName, Object key) {
			Object record = getSqlSession().selectOne(statementName, key);
			return record;
		}

		public int updateByPrimaryKey(String statementName, Object record) {
			int rows = sqlSessionTemplate.update(statementName, record);
			return rows;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List selectList(final String statementName,
				final Object parameterObject) {
			List result = sqlSessionTemplate
					.selectList(statementName, parameterObject);
			return result;
		}

		public Object selectObject(final String statementName,
				final Object parameterObject) {
			Object result = getSqlSession().selectOne(statementName,
					parameterObject);
			return result;
		}

		public int batchInsert(final String statementName, final List<?> parameters) {
			int i = 0;
			for (Object record : parameters) {
				insert(statementName, record);
				i++;
			}
			return i;
		}

		public int batchUpdate(final String statementName, final List<?> parameters) {
			int i = 0;
			for (Object record : parameters) {
				update(statementName, record);
				i++;
			}
			return i;
		}
}
