object StringDemo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(37); 
  val s = "Hello";System.out.println("""s  : String = """ + $show(s ));$skip(35); val res$0 = 
  //
  // Usual methods
  s.length;System.out.println("""res0: Int = """ + $show(res$0));$skip(19); val res$1 = 
  s + " Hi Again!";System.out.println("""res1: String = """ + $show(res$1));$skip(13); val res$2 = 
  s.getBytes;System.out.println("""res2: Array[Byte] = """ + $show(res$2));$skip(56); 
  
  // Testing String Equality
  val s1 = "H" + "ello";System.out.println("""s1  : String = """ + $show(s1 ));$skip(10); val res$3 = 
  s1 == s;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(12); val res$4 = 
  null == s;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(30); val res$5 = 
  s.equalsIgnoreCase("hello");System.out.println("""res5: Boolean = """ + $show(res$5));$skip(49); val res$6 = 
  
  "eggs, milk, butter".split(",").map(_.trim);System.out.println("""res6: Array[String] = """ + $show(res$6));$skip(49); 
  
  // String interpolation
  val name = "Fred";System.out.println("""name  : String = """ + $show(name ));$skip(15); 
  val age = 33;System.out.println("""age  : Int = """ + $show(age ));$skip(29); val res$7 = 
  s"$name is $age years old";System.out.println("""res7: String = """ + $show(res$7));$skip(31); val res$8 = 
  s"Age next year: ${age + 1}";System.out.println("""res8: String = """ + $show(res$8));$skip(33); val res$9 = 
  f"$name is $age%.2f years old";System.out.println("""res9: String = """ + $show(res$9));$skip(25); val res$10 = 
  raw"It's raw\n String";System.out.println("""res10: String = """ + $show(res$10));$skip(56); val res$11 = 
  // Older way
  "%s is %d years old".format(name, age);System.out.println("""res11: String = """ + $show(res$11));$skip(82); 
  
  // Create Multiline Strings
  val ms1 = """This is
  a multiline
  String""";System.out.println("""ms1  : String = """ + $show(ms1 ));$skip(104); 
  val ms2 = """This is
  |a "multiline"
  |String.
  |How's it?""".
  stripMargin.replaceAll("\n", " ");System.out.println("""ms2  : String = """ + $show(ms2 ));$skip(74); val res$12 = 
  
  //
  // can be considered as sequence of chars
  s.filter(_ != 'l');System.out.println("""res12: String = """ + $show(res$12));$skip(19); 
  s.foreach(print);$skip(37); val res$13 = 
  for (c <- "hello") yield c.toUpper;System.out.println("""res13: String = """ + $show(res$13));$skip(31); val res$14 = 
  s.drop(2).take(2).capitalize;System.out.println("""res14: String = """ + $show(res$14));$skip(19); val res$15 = 
  s.map(_.toUpper);System.out.println("""res15: String = """ + $show(res$15));$skip(47); 
  
  
  // Regex
  val numPattern = "[0-9]+".r;System.out.println("""numPattern  : scala.util.matching.Regex = """ + $show(numPattern ))}

}
