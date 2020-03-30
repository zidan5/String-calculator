public class TestStringCalculator {

        @Test
        public void addReturnsZero() throws Exception {
            Assert.assertEquals(StringCalculator.Add(""), 0);
        }
        @Test
        public void addReturnsOneValue() throws Exception{
            Assert.assertEquals(StringCalculator.Add("1"), 1);
        }
        @Test
        public void addReturnsMultipleValues() throws Exception{
            Assert.assertEquals(StringCalculator.Add("1,1"),2);
        }
        @Test
        public void addNewLine() throws Exception{
            Assert.assertEquals(StringCalculator.Add("1\n2,3"),  6);
        }
        @Test
        public void addDelimiter() throws Exception{
            Assert.assertEquals(StringCalculator.Add("//;\n1;2"), 3);
        }
        @Test
        public void addIgnoresIntegersGreaterThan1000() throws Exception{
            Assert.assertEquals(StringCalculator.Add("//;\n1000,1;2"), 3);
        }
        @Test
        public void addDelimiterOfAnyLength() throws Exception{
            Assert.assertEquals(StringCalculator.Add("//***\n1***2***3"),6);
        }
        @Test
        public void addDifferentDelimitersOfAnyLength() throws Exception{
            Assert.assertEquals(StringCalculator.Add("//[abc][777][:(]\n1abc27773:(1"), 7);
        }
  }
