package ci.bourse.renouv.service.impl;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bourse.renouv.dao.BourseDao;
import ci.bourse.renouv.dao.BoursierDao;
import ci.bourse.renouv.service.BoursierService;

@Service
@Transactional
public class BoursierServiceImpl extends AbstractService implements BoursierService {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	private BoursierDao boursierDao;

	@Resource
	private BourseDao bourseDao;

	@Override
	public Map<String, Double> trouverMontantBourseParAnnee(final Integer nbAnneeMax,
			final Integer anneeCourante){
		final Map<String, Double> res = new TreeMap<String, Double>();

		for (Integer i = 0; i < nbAnneeMax; i++) {
			final Double montant = boursierDao
					.trouverMontantBoursePour(anneeCourante - i);
			res.put(String.valueOf(anneeCourante - i), montant);
		}

		return res;
	}

	@Override
	public Map<String, Integer> trouverNombreBoursierParPays(){
		return bourseDao.trouverNombreBoursierParPays();
	}

	@Override
	public Integer trouverNombreTotalBoursier(){
		return boursierDao.trouverNombreTotalBoursier();
	}

}
