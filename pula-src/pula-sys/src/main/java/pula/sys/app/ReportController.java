/**
 * 
 */
package pula.sys.app;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pula.sys.daos.TimeCourseUsageDao;
import pula.sys.domains.TimeCourseOrderUsage;

/**
 * Provide daily order report based on branch
 * <br/> 
 * 每日全部 每日某个分部的上课单子 某个学生的全部上课订单
 * *消费页可直接查*
 * 
 * @author Administrator
 *
 */
@Controller
public class ReportController {

	@Autowired
	private TimeCourseUsageDao usageDao;

	@RequestMapping
	public ModelAndView entry(@RequestParam(value="branch", required = false) String branch,
			@RequestParam(value = "date", required = false) String startDate) {
	    Date givenDate = null;
		if (startDate == null) {
		    givenDate = new Date();
		} else {
		    DateTime dt = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(startDate);
		    givenDate = dt.toDate();
		}

		List<TimeCourseOrderUsage> usages = readCourseUsage(usageDao, branch, givenDate);

		ModelAndView view = new ModelAndView();
		view.addObject("usages", usages);
		view.addObject("branch", branch);
		view.addObject("date", startDate);
		return view;
	}

    public static List<TimeCourseOrderUsage> readCourseUsage(TimeCourseUsageDao usageDao, String branch, Date startDate) {
        String hql = " select usage, student "
                + " From "
                + " TimeCourseOrderUsage usage,"
                + " TimeCourse course, "
                + " Student student "
                + " WHERE usage.usageTime = '%s' and course.branchName = '%s' "
                + " AND usage.courseNo = course.no "
                + " AND usage.studentNo = student.no ";
        hql = String.format(hql, DateTimeFormat.longDate().print(startDate.getTime()), branch);

        List<TimeCourseOrderUsage> courseUsages = usageDao.find(hql);

        return courseUsages;
    }

}
