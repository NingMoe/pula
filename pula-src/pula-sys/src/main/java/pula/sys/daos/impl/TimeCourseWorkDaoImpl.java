/**
 * 
 */
package pula.sys.daos.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import puerta.support.PageInfo;
import puerta.support.PaginationSupport;
import puerta.support.Pe;
import puerta.support.utils.MD5;
import puerta.support.utils.RandomTool;
import puerta.system.base.HibernateGenericDao;
import pula.sys.conditions.TimeCourseWorkCondition;
import pula.sys.daos.TimeCourseWorkDao;
import pula.sys.domains.TimeCourseWork;

/**
 * @author Liangfei
 *
 */
@Repository
public class TimeCourseWorkDaoImpl extends HibernateGenericDao<TimeCourseWork, Long> implements TimeCourseWorkDao {

    @Override
    public PaginationSupport<TimeCourseWork> search(TimeCourseWorkCondition condition, int pageIndex) {
        DetachedCriteria criteria = makeSearchCriteria(condition);
        return super.findPageByCriteria(criteria, new PageInfo(pageIndex), Order.desc("updateTime"));
    }

    public DetachedCriteria makeSearchCriteria(TimeCourseWorkCondition condition) {
        DetachedCriteria dc = DetachedCriteria.forClass(this.pojoClass, "uu");
        if (!StringUtils.isEmpty(condition.getStudentNo())) {
            dc.add(Restrictions.like("studentNo", condition.getStudentNo()));
        }

        if (!StringUtils.isEmpty(condition.getCourseNo())) {
            dc.add(Restrictions.like("courseNo", condition.getCourseNo()));
        }
        
        if (condition.getLimitedWorkEffectDate() != null) {
            dc.add(Restrictions.eq("workEffectDate", condition.getLimitedWorkEffectDate()));
        }

        if (condition.getRate() >= 0) {
            dc.add(Restrictions.eq("rate", condition.getRate()));
        }

        if (domainPo) {
            dc.add(Restrictions.eq("removed", false));
        }

        return dc;
    }

    @Override
    public TimeCourseWork save(TimeCourseWork cc) {
        if (StringUtils.isEmpty(cc.getNo())) {
            cc.setNo(MD5.GetMD5String("" + System.currentTimeMillis()));
        }

        cc.setCreateTime(new Date());
        cc.setUpdateTime(new Date());
        cc.setAttachmentKey(RandomTool.getRandomString(10));
        cc.setEnabled(true);
        _save(cc);
        return cc;
    }

    @Override
    public TimeCourseWork update(TimeCourseWork cc) {
        if (super.existsNo(cc.getNo(), cc.getId())) {
            Pe.raise("课程作业编号已经存在:" + cc.getNo());
        }

        TimeCourseWork existed = this.findById(cc.getId());
        if (existed == null) {
            Pe.raise(String.format("订单课程作业编号不存在: %d ！", cc.getId()));
        }

        existed.setUpdateTime(new Date());
        existed.setComments(cc.getComments());
        existed.setCourseNo(cc.getCourseNo());
        existed.setImagePath(cc.getImagePath());
        existed.setRate(cc.getRate());
        existed.setStudentNo(cc.getStudentNo());
        existed.setWorkEffectDate(cc.getWorkEffectDate());
        existed.setBranchNo(cc.getBranchNo());
        existed.setUpdator(cc.getUpdator());

        _update(existed);
        return existed;
    }

}
