package code._4_student_effort;

public class Main {

  public static void main(String[] args) {
    FizzBuzz();
  }

  private static void FizzBuzz() {
    for(int i = 1; i <= 100 ; i++)
      System.out.println(putCorrectOutput(i));
  }

  private static String putCorrectOutput(int i) {
    String output = "";
    if(i % 3 == 0)
      output += "Fizz";
    if(i % 5 == 0)
      output += "Buzz ";
    if(output.equals(""))
      output += i;
    return output;
  }
}
