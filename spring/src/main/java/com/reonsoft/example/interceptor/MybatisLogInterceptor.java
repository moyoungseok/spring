package com.reonsoft.example.interceptor;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({
	@Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
	@Signature(type = Executor.class, method = "query",  args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })
	})
public class MybatisLogInterceptor implements Interceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final String [] primitveType = new String[] {"java.lang.Character", "java.lang.Boolean", "java.lang.String", "java.lang.Byte", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double"};

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		Object [] args = invocation.getArgs(); // [0] : MappedStatement, [1] : parameter, [2] : RowBounds [3] : null
		
		MappedStatement mappedStatement = (MappedStatement) args[0];
		BoundSql boundSql               = mappedStatement.getBoundSql(args[1]);
		
		Object param    = boundSql.getParameterObject();
		String sql      = boundSql.getSql();
		String sqlParam = "";
		
		if(param != null) {
			
			List<ParameterMapping> parameterMapping = boundSql.getParameterMappings();
			
			sqlParam = param.getClass().getName() + "[";
			
			for(ParameterMapping mapping : parameterMapping) {
				
				String propValue = mapping.getProperty(); // Mybatis #{prameter}
				
				// ¼öÁ¤
				
//				sql = sql.replaceFirst("\\?", "#{" + propValue + "}");
				
				if(Arrays.asList(primitveType).contains(param.getClass().getName())) {
					sqlParam += propValue + "=" + param;
					sql = sql.replaceFirst("\\?", param + " /*" + propValue + "*/");
				} else {
					for(Method methods : param.getClass().getMethods()) {
						if(methods.getName().toLowerCase().equals(("get" + propValue).toLowerCase())) {
							sqlParam += propValue + "=" + String.valueOf(methods.invoke(param)) + ", ";
	//						sql = sql.replaceFirst("\\?", String.valueOf(methods.invoke(param)));
							sql = sql.replaceFirst("\\?", String.valueOf(methods.invoke(param)) + " /*" + propValue + "*/");
						}
					}
				}
			}
			
			if(sqlParam.lastIndexOf(",") != -1) {
				sqlParam = sqlParam.substring(0, sqlParam.lastIndexOf(","));
			}
			
			sqlParam += "]";
		}
		
		logger.info("sql\n{}", sql);
		logger.info("sqlParam\n{}", sqlParam);
		
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}

}
