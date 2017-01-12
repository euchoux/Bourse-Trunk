package ci.bourse.renouv.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AbstractService {

	@Autowired
	private ApplicationContext applicationContext;

	public AbstractService() {
	}

	/**
	 * @return Application context mapper.
	 */
	public Mapper getMapper() {
		return (Mapper) applicationContext.getBean("org.dozer.mapper");
	}

}
