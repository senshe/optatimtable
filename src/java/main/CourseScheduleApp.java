/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import beans.Course;
import beans.CourseSchedule;
import beans.Day;
import beans.Lecture;
import beans.Period;
import beans.Room;
import beans.Teacher;
import dao.CourseDao;
import dao.DayDao;
import dao.LectureDao;
import dao.PeriodDao;
import dao.RoomDao;
import dao.TeacherDao;
import java.util.ArrayList;
import java.util.List;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import org.optaplanner.core.impl.score.director.ScoreDirectorFactory;

/**
 *
 * @author ElBastamy
 */
public class CourseScheduleApp {

    public static final String SOLVER_CONFIG_XML = "solver/SolverConfig.xml";
    public static ScoreDirector scoreDirector;
    public static int printCount = 0;
    public static CourseSchedule solution;

    private static List<Teacher> teacherList;
  //  private static List<Curriculum> curriculumList;
  
    private static List<Course> courseList;
    private static List<Day> dayList;
  
    private static List<Period> periodList;
    private static List<Room> roomList;

   // private static List<Timetable> timetableList;
  

    private static List<Lecture> lectureList;

    public static void main(String[] args) {
        
        Solver solver = SolverFactory.createFromXmlResource(SOLVER_CONFIG_XML).buildSolver();
        ScoreDirectorFactory scoreDirectorFactory = solver.getScoreDirectorFactory();
        scoreDirector = scoreDirectorFactory.buildScoreDirector();
        init();
        solution = new CourseSchedule();

        solution.setCourseList(courseList);
  

        solution.setDayList(dayList);
        
        
        solution.setLectureList(lectureList);
        
        solution.setName("test1");
        
        solution.setPeriodList(periodList);
        
        solution.setRoomList(roomList);
        
        solution.setTeacherList(teacherList);
        
        
    
        scoreDirector.setWorkingSolution(solution);
        
        System.out.println("\n\nTRYING COUNT AT:");
        solver.solve(solution);
        CourseSchedule bestHelloSolution = (CourseSchedule) solver.getBestSolution();

        System.out.println("\n\nBEST SOLUTION  " + bestHelloSolution.getLectureList().size());
  LectureDao dao5=new LectureDao();
        for (Lecture l : bestHelloSolution.getLectureList()) {
          
            System.out.println( l.getIdCourse().getCode()+"<  >" + l.getIdPeriod().getIdDay().getName()+"-" +l.getIdPeriod().getIdTimeslot().getH()+ "<  >" + l.getIdRoom().getCode());
        }
    }

        public static void init() {
            CourseDao dao1=new CourseDao();

            TeacherDao dao2=new TeacherDao();
            DayDao dao4=new DayDao();

            LectureDao dao5=new LectureDao();

            PeriodDao dao6=new PeriodDao();

            RoomDao dao7=new RoomDao();

           

         //   UnavailableperiodpenaltyDao dao10=new UnavailableperiodpenaltyDao();
//lectureList=new ArrayList<>();
            teacherList =dao2.getAll().subList(0, 1);
            courseList =dao1.getAll().subList(0, 3);
            dayList =dao4.getAll().subList(0, 0);
            periodList =dao6.getAll().subList(0, 2);
            roomList =dao7.getAll().subList(0, 2);
//            unavailablePeriodPenaltyList =dao10.getAll();
            lectureList =dao5.getAll();
            
//        Lecture lecture1 = new Lecture();
//        lecture1.setId(1);
//        lecture1.setIdCourse(courseList.get(0));
//        lecture1.setLectureIndexInCourse(1);
//        lecture1.setLocked(false);
//        
////        lecture1.setPeriod(period0);
////        lecture1.setRoom(roomB);
//
//        Lecture lecture2 = new Lecture();
//        lecture2.setId(2);
//        lecture2.setIdCourse(courseList.get(0));
//        lecture2.setLectureIndexInCourse(0);
//        lecture2.setLocked(false);
////        lecture2.setPeriod(period1);
////        lecture2.setRoom(roomB);
//
//        Lecture lecture3 = new Lecture();
//        lecture3.setId(3);
//        lecture3.setIdCourse(courseList.get(1));
//        lecture3.setLectureIndexInCourse(0);
//        lecture3.setLocked(false);
////        lecture3.setPeriod(period2);
////        lecture3.setRoom(roomB);
//
//        Lecture lecture4 = new Lecture();
//        lecture4.setId(4);
//        lecture4.setIdCourse(courseList.get(2));
//        lecture4.setLectureIndexInCourse(0);
//        lecture4.setLocked(false);
////        lecture4.setPeriod(period1);
////        lecture4.setRoom(roomB);
//        lectureList.add(lecture1);
//        lectureList.add(lecture2);
//        lectureList.add(lecture3);
     //   lectureList.add(lecture4);
    }

}
