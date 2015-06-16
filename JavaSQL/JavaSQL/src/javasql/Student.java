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
    public Student(){
        this.StuNumber = StuNumber;
        this.StuName = StuName;
        this.StuSexual = StuSexual;
        this.StuAge = StuAge;
        this.StuGrade = StuGrade;
        this.StuClass = StuClass;
        this.StuScore = StuScore;
    }
    public String getStuNumber(){
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
    public void setStuNumber(String StuNumber){
        this.StuNumber=StuNumber;
    }
    public void setStuName(String StuName){
        this.StuName=StuName;
    }
    public void setStuSexual(String StuSexual){
        this.StuSexual=StuSexual;
    }
    public void setStuAge(String StuAge){
        this.StuAge=StuAge;
    }
    public void setStuGrade(String StuGrade){
        this.StuGrade=StuGrade;
    }
        public void setStuClass(String StuClass){
        this.StuClass=StuClass;
    }
        public void setStuScore(String StuScore){
        this.StuScore=StuScore;
    }
}
