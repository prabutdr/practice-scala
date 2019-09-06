object StringDemo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(37); 
  val s = "Hello";System.out.println("""s  : String = """ + $show(s ));$skip(35); val res$0 = 
  //
  // Usual methods
  s.length;System.out.println("""res0: Int = """ + $show(res$0));$skip(19); val res$1 = 
  s + " Hi Again!";System.out.println("""res1: String = """ + $show(res$1));$skip(13); val res$2 = 
  s.getBytes;System.out.println("""res2: Array[Byte] = """ + $show(res$2));$skip(44); val res$3 = 
  // extracting specific char
  s.charAt(0);System.out.println("""res3: Char = """ + $show(res$3));$skip(26); val res$4 = 
  // same as above
  s(0);System.out.println("""res4: Char = """ + $show(res$4));$skip(56); 
  
  // Testing String Equality
  val s1 = "H" + "ello";System.out.println("""s1  : String = """ + $show(s1 ));$skip(10); val res$5 = 
  s1 == s;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(12); val res$6 = 
  null == s;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(30); val res$7 = 
  s.equalsIgnoreCase("hello");System.out.println("""res7: Boolean = """ + $show(res$7));$skip(49); val res$8 = 
  
  "eggs, milk, butter".split(",").map(_.trim);System.out.println("""res8: Array[String] = """ + $show(res$8));$skip(49); 
  
  // String interpolation
  val name = "Fred";System.out.println("""name  : String = """ + $show(name ));$skip(15); 
  val age = 33;System.out.println("""age  : Int = """ + $show(age ));$skip(29); val res$9 = 
  s"$name is $age years old";System.out.println("""res9: String = """ + $show(res$9));$skip(31); val res$10 = 
  s"Age next year: ${age + 1}";System.out.println("""res10: String = """ + $show(res$10));$skip(33); val res$11 = 
  f"$name is $age%.2f years old";System.out.println("""res11: String = """ + $show(res$11));$skip(25); val res$12 = 
  raw"It's raw\n String";System.out.println("""res12: String = """ + $show(res$12));$skip(56); val res$13 = 
  // Older way
  "%s is %d years old".format(name, age);System.out.println("""res13: String = """ + $show(res$13));$skip(82); 
  
  // Create Multiline Strings
  val ms1 = """This is
  a multiline
  String""";System.out.println("""ms1  : String = """ + $show(ms1 ));$skip(104); 
  val ms2 = """This is
  |a "multiline"
  |String.
  |How's it?""".
  stripMargin.replaceAll("\n", " ");System.out.println("""ms2  : String = """ + $show(ms2 ));$skip(74); val res$14 = 
  
  //
  // can be considered as sequence of chars
  s.filter(_ != 'l');System.out.println("""res14: String = """ + $show(res$14));$skip(19); 
  s.foreach(print);$skip(37); val res$15 = 
  for (c <- "hello") yield c.toUpper;System.out.println("""res15: String = """ + $show(res$15));$skip(31); val res$16 = 
  s.drop(2).take(2).capitalize;System.out.println("""res16: String = """ + $show(res$16));$skip(19); val res$17 = 
  s.map(_.toUpper);System.out.println("""res17: String = """ + $show(res$17));$skip(47); 
  
  
  // Regex
  val numPattern = "[0-9]+".r;System.out.println("""numPattern  : scala.util.matching.Regex = """ + $show(numPattern ));$skip(61); val res$18 = 
  // same as above
  new scala.util.matching.Regex("[0-9]+");System.out.println("""res18: scala.util.matching.Regex = """ + $show(res$18));$skip(65); 
  // finding matches
  val address = "123 Main Street Suite 101";System.out.println("""address  : String = """ + $show(address ));$skip(47); 
  val doorNo = numPattern.findFirstIn(address);System.out.println("""doorNo  : Option[String] = """ + $show(doorNo ));$skip(46); 
  val matches = numPattern.findAllIn(address);System.out.println("""matches  : scala.util.matching.Regex.MatchIterator = """ + $show(matches ));$skip(18); val res$19 = 
  matches.toArray;System.out.println("""res19: Array[String] = """ + $show(res$19));$skip(62); val res$20 = 
  
  // Replacing patterns
  address.replaceAll("[0-9]", "x");System.out.println("""res20: String = """ + $show(res$20));$skip(39); val res$21 = 
	numPattern.replaceAllIn(address, "Y");System.out.println("""res21: String = """ + $show(res$21));$skip(37); val res$22 = 
  address.replaceFirst("[0-9]", "x");System.out.println("""res22: String = """ + $show(res$22));$skip(66); 
  
  // Extracting parts
  val pattern = "([0-9]+) ([A-Za-z]+)".r;System.out.println("""pattern  : scala.util.matching.Regex = """ + $show(pattern ));$skip(43); 
  val pattern(count, fruit) = "10 Bananas"
                                       
                                                  
  // Add your own methods to the String class
  // via implicit conversions
  implicit class StringImprovement(s: String) {
    def increment: String = s.map(c => (c + 1).toChar)
    def decrement: String = s.map(c => (c - 1).toChar)
  };System.out.println("""count  : String = """ + $show(count ));System.out.println("""fruit  : String = """ + $show(fruit ));$skip(347); val res$23 = 
  "HAL".increment;System.out.println("""res23: String = """ + $show(res$23));$skip(18); val res$24 = 
  "IBM".decrement;System.out.println("""res24: String = """ + $show(res$24))}
}
