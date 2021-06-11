package com.ledungcobra.daos;

import com.ledungcobra.applicationcontext.AppContext;
import com.ledungcobra.entites.Class;
import com.ledungcobra.entites.CourseInfo;
import com.ledungcobra.entites.Semester;
import com.ledungcobra.entites.StudentAccount;
import com.ledungcobra.utils.DatetimeUtil;
import lombok.val;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class StudentDao extends BaseDao<StudentAccount, String> implements UserDao<StudentAccount>
{

    public StudentDao(Session session)
    {
        super(session);
    }

    @Override
    public StudentAccount findByUserName(String studentCardId)
    {
        return (StudentAccount) session
                .createQuery("from StudentAccount sa where sa.studentCardId=:val")
                .setParameter("val", studentCardId).getSingleResult();
    }

    public List<StudentAccount> searchStudent(Class classEntity, String keyword)
    {
        boolean isDateTime = DatetimeUtil.isDate(keyword);

        try
        {
            if (!isDateTime)
            {
                val query = this.session.createQuery(
                        "select distinct  s from StudentAccount s " +
                                " left join fetch s.educationType e" +
                                " left join fetch s.studentInfo si where s.studiedClass=:class and " +
                                "( si.fullName like :k or " +
                                "s.studentCardId  like :k or " +
                                "si.gender like :k or " +
                                " e.name like :k or " +
                                "si.identityCardNumber like :k)");

                query.setParameter("class", classEntity);
                query.setParameter("k", "%" + keyword + "%");
                return (List<StudentAccount>) query.getResultList();
            } else
            {
                val query = this.session.createQuery(
                        "select distinct s from StudentAccount s where s.studentInfo.birthdate=:date");
                query.setParameter("date", AppContext.dateFormat.parse(keyword));
                return (List<StudentAccount>) query.getResultList();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    public void addStudentToClass(StudentAccount student, Class classEntity)
    {
        student.setStudiedClass(classEntity);
        session.saveOrUpdate(student);
    }

    public List<StudentAccount> searchStudentRegACourse(String keyword, CourseInfo courseInfo, Semester semester)
    {
        try
        {
            val query = this.session.createQuery(
                    "select distinct sc from StudentCourse  sc" +
                            " join fetch sc.studentCourseId.studentAccount st " +
                            " join fetch sc.id.course c " +
                            " join  fetch  sc.id.semester se " +
                            "where c.courseInfo=:courseInfo and " +
                            "se=:semester and " +
                            " ( c.dayToStudyInWeek like :k or " +
                            "c.shiftToStudyInDay like :k or " +
                            " c.teacherName like :k or " +
                            "   st.studentCardId like :k or " +
                            "   st.studentInfo.gender like :k or " +
                            "   st.studentInfo.fullName like :k  or " +
                            "   st.studentInfo.identityCardNumber like :k  )");
            query.setParameter("k", "%" + keyword + "%");
            query.setParameter("courseInfo", courseInfo);
            query.setParameter("semester", semester);
            return (List<StudentAccount>) query.getResultList();

        } catch (Exception e)
        {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
