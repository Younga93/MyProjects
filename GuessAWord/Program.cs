using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GuessAWord
{
    class Program
    {
        /* Younga Jin
		 * Date: November 23, 2019
		 */
        static void Main(string[] args)
        {
            string[] words = new string[] { "programming", "software", "engineering", "centennial", "christmas", "thanksgiving", "computer", "lovelace" };

            Random ranNumberGenerator = new Random();
            int selector;
            selector = ranNumberGenerator.Next(0, words.Length);

            char[] answer = new char[words[selector].Length];
            char[] output = new char[answer.Length];
            for (int i = 0; i < answer.Length; i++)
            {
                answer[i] = words[selector][i];
                output[i] = '*';
            }

            char userInput;
            int endingChecker;
            do
            {
                Console.Write("Word: ");
                for (int i = 0; i < output.Length; i++)
                {
                    Console.Write(output[i]);
                }
                Console.WriteLine();

                Console.Write("Guess an letter. >>");
                userInput = Convert.ToChar(Console.ReadLine().ToLower());

                bool answerMarker = false;
                endingChecker = 0;
                for (int i = 0; i < answer.Length; i++)
                {
                    if (answer[i] == userInput)
                    {
                        output[i] = userInput;
                        answerMarker = true;
                    }
                    if (output[i] == '*')
                    {
                        endingChecker++;
                    }
                }

                if (answerMarker)
                {
                    Console.WriteLine($"Yes! {userInput} is in the word.");
                }
                else
                {
                    Console.WriteLine($"Sorry. {userInput} is not in the word.");
                }
            } while (endingChecker != 0);
            Console.WriteLine($"Congratulation! The word is '{words[selector]}'!");
        }
    }
}
