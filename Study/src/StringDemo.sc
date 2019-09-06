object StringDemo {
  val s = "Hello"
  //
  // Usual methods
  s.length
  s + " Hi Again!"
  s.getBytes
  // extracting specific char
  s.charAt(0)
  // same as above
  s(0)
  
  // Testing String Equality
  val s1 = "H" + "ello"
  s1 == s
  null == s
  s.equalsIgnoreCase("hello")
  
  "eggs, milk, butter".split(",").map(_.trim)
  
  // String interpolation
  val name = "Fred"
  val age = 33
  s"$name is $age years old"
  s"Age next year: ${age + 1}"
  f"$name is $age%.2f years old"
  raw"It's raw\n String"
  // Older way
  "%s is %d years old".format(name, age)
  
  // Create Multiline Strings
  val ms1 = """This is
  a multiline
  String"""
  val ms2 = """This is
  |a "multiline"
  |String.
  |How's it?""".
  stripMargin.replaceAll("\n", " ")
  
  //
  // can be considered as sequence of chars
  s.filter(_ != 'l')
  s.foreach(print)
  for (c <- "hello") yield c.toUpper
  s.drop(2).take(2).capitalize
  s.map(_.toUpper)
  
  
  // Regex
  val numPattern = "[0-9]+".r
  // same as above
  new scala.util.matching.Regex("[0-9]+")
  // finding matches
  val address = "123 Main Street Suite 101"
  val doorNo = numPattern.findFirstIn(address)
  val matches = numPattern.findAllIn(address)
  matches.toArray
  
  // Replacing patterns
  address.replaceAll("[0-9]", "x")
	numPattern.replaceAllIn(address, "Y")
  address.replaceFirst("[0-9]", "x")
  
  // Extracting parts
  val pattern = "([0-9]+) ([A-Za-z]+)".r
  val pattern(count, fruit) = "10 Bananas"
                                       
                                                  
  // Add your own methods to the String class
  // via implicit conversions
  implicit class StringImprovement(s: String) {
    def increment: String = s.map(c => (c + 1).toChar)
    def decrement: String = s.map(c => (c - 1).toChar)
  }
  "HAL".increment
  "IBM".decrement
}