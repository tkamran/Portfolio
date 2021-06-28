package cs3220;

public class Question {
	  
String desc;
String ansA;
String ansB;
String ansC;
int correct;

public Question(String desc, String ansA, String ansB, String ansC, int correct)
{
   this.desc = desc;
   this.ansA = ansA;
   this.ansB = ansB;
   this.ansC = ansC;
   this.correct = correct;
}
public String getDesc() {
   return desc;
}
public void setDesc(String desc) {
   this.desc = desc;
}
public String getAnsA() {
   return ansA;
}
public void setAnsA(String ansA) {
   this.ansA = ansA;
}
public String getAnsB() {
   return ansB;
}
public void setAnsB(String ansB) {
   this.ansB = ansB;
}
public String getAnsC() {
   return ansC;
}
public void setAnsC(String ansC) {
   this.ansC = ansC;
}
public int getCorrect() {
   return correct;
}
public void setCorrect(int correct) {
   this.correct = correct;
}
}