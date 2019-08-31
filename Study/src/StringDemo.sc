object StringDemo {
  val s = "Hello"                                 //> s  : String = Hello
  //
  // Usual methods
  s.length                                        //> res0: Int = 5
  s + " Hi Again!"                                //> res1: String = Hello Hi Again!
  s.getBytes                                      //> res2: Array[Byte] = Array(72, 101, 108, 108, 111)
  
  // Testing String Equality
  val s1 = "H" + "ello"                           //> s1  : String = Hello
  s1 == s                                         //> res3: Boolean = true
  null == s                                       //> res4: Boolean = false
  s.equalsIgnoreCase("hello")                     //> res5: Boolean = true
  
  "eggs, milk, butter".split(",").map(_.trim)     //> res6: Array[String] = Array(eggs, milk, butter)
  
  // String interpolation
  val name = "Fred"                               //> name  : String = Fred
  val age = 33                                    //> age  : Int = 33
  s"$name is $age years old"                      //> res7: String = Fred is 33 years old
  s"Age next year: ${age + 1}"                    //> res8: String = Age next year: 34
  f"$name is $age%.2f years old"                  //> res9: String = Fred is 33.00 years old
  raw"It's raw\n String"                          //> res10: String = It's raw\n String
  // Older way
  "%s is %d years old".format(name, age)          //> res11: String = Fred is 33 years old
  
  // Create Multiline Strings
  val ms1 = """This is
  a multiline
  String"""                                       //> ms1  : String = This is
                                                  //|   a multiline
                                                  //|   String
  val ms2 = """This is
  |a "multiline"
  |String.
  |How's it?""".
  stripMargin.replaceAll("\n", " ")               //> ms2  : String = This is a "multiline" String. How's it?
  
  //
  // can be considered as sequence of chars
  s.filter(_ != 'l')                              //> res12: String = Heo
  s.foreach(print)                                //> Hello
  for (c <- "hello") yield c.toUpper              //> res13: String = HELLO
  s.drop(2).take(2).capitalize                    //> res14: String = Ll
  s.map(_.toUpper)                                //> res15: String = HELLO
  
  
  // Regex
  val numPattern = "[0-9]+".r                     //> numPattern  : scala.util.matching.Regex = [0-9]+

}