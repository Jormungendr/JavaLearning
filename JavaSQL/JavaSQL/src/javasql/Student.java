/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasql;
import java.sql.*;
import java.io.*;
import java.util.*;
        
public class Student {
    public String StuNumber;
    public String StuName;
    public String StuSexual;
    public String StuAge;
    public String StuGrade;
    public String StuClass;
    public String StuScore;
    public Student(String StuNumber, String StuName,StuSexual,StuAge,StuGrade,StuClass,StuScore){
        this.StuNumber = StuNumber;
        this.StuSexsual = StuSexual;
        this.StuAge = StuAge;
        this.StuGrade = StuGrade;
        this.StuClass = StuClass;
        this.StuScore = StuScore;
    }
    public String getStuNmber(){
        return StuNumber;
    }
    public String getStuName(){
        return StuName;
    }
   public String getStuSexual(){
        return StuSexual;
    }
    public String getStuAge(){
        return StuAge;
    }
    public String getStuGrade(){
        return StuGrade;
    }
    public String getStuClass(){
        return StuClass;
    }
    public String getStuScore(){
        return StuScore;
    }
    public void setStuNumber(){
        this.StuNumber=StuNumber;
    }
    public void setStuName(){
        this.StuName=StuName;
    }
    public void setStuSexual(){
        this.StuSexual=StuSexual;
    }
    public void setStuAge(){
        this.StuAge=StuAge;
    }
    public void setStuGrade(){
        this.StuGrade=StuGrade;
    }
        public void setStuClass(){
        this.StuClass=StuClass;
    }
        public void setStuScore(){
        this.StuScore=StuScore;
    }
}
