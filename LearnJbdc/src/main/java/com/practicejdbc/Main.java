package com.practicejdbc;

/*
    Import package
    load and register
    create connection
    create statement
    execute statement
    process the results
    close
 */

// Import package
import java.sql.*;
import java.util.Arrays;
import java.util.List;

class Student{
    private int sid;
    private String name;
    private int marks;

    public Student(int id, String name, int marks){
        this.name = name;
        this.sid = id;
        this.marks = marks;
    }
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

class Main{

    public static void main(String[] args){
        handlePrepareStatement();

        //NOTE USING STATEMENT IS RISKY AS IT CAN LEAD TO SQL INJECTION
        //USE PREPARE STATEMENT
        //PrepareStatement also has a performance boost compared to statement as the SQL is precompiled.
    }

    public static void handlePrepareStatement(){
        //jdbc:postgresql is a must, ://localhost:5432/demo is the name of the database I have in postgres
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "Benten2014@";
        String sql = "insert into students values (?,?,?)";

        int sid = 101;
        String sname = "Big Test";
        int mark = 99;


        try{
            Connection con = DriverManager.getConnection(url,username,password);
            //This will give a pre-compiled query you can use for caching purpose
            //Good to use this to also prevent SQL injection
            PreparedStatement st = con.prepareStatement(sql);

            //This will set the values in the sql query passed to prepareStatement
            st.setInt(1, sid);
            st.setString(2, sname);
            st.setInt(3, mark);

            st.execute();

        } catch (SQLException e) {
            System.out.println("Error with connection " + e.getMessage());
        }




    }

    public static void handleQueryPractice(){
        String query1 = "Select * FROM students";
        List<Student> students = Arrays.asList(
                new Student(2, "Test1", 70),
                new Student(3, "Test2", 88),
                new Student(4, "Test3", 65)
        );

        System.out.println("Database values before update");
        getTableData(query1);

        /*
            Update query
            update student set sname='Test0' where sid=1

            Delete query
            delete from student where sid=1
         */

        for(Student s : students){
            String query2 = "INSERT INTO students VALUES " +
                    "("
                    + s.getSid() + ","
                    + "'" + s.getName() +"'" + ","
                    + s.getMarks() +
                    ");";
            setTableData(query2);
        }
        System.out.println("Database values after update");
        getTableData(query1);
    }

    public static void getTableData(String query){
        //jdbc:postgresql is a must, ://localhost:5432/demo is the name of the database I have in postgres
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "Benten2014@";

        try{
            //create Connection
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established....");
            //Create Statement
            Statement st = con.createStatement();
            //Execute Statement
            ResultSet data = st.executeQuery(query);
            //Process the results
            //Always use .next() the pointer in the database will be at the header level, you need to move it
            //To the database. This won't give error because I did it in the if statement.
            while(data.next()) {
                int id = data.getInt("sid");
                String name = data.getString("sname");
                int marks = data.getInt("mark");
                System.out.printf("%d\t%s\t%d\n",id,name,marks);
            }
            //Close connection
            con.close();
            System.out.println("Connection Close...");
        } catch (SQLException e) {
            System.out.println("Error with connection " + e.getMessage());
        }
    }

    public static void setTableData(String query){
        //jdbc:postgresql is a must, ://localhost:5432/demo is the name of the database I have in postgres
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "Benten2014@";
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            int response = st.executeUpdate(query);
            if(response > 0)
                System.out.println("Data updated");
            else
                throw new SQLException("Error setting data");
            con.close();
        }catch(SQLException e){
            System.out.println("Error with message " + e.getMessage());
        }
    }
}