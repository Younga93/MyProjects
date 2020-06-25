using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem01
{
    class Program
    {
    /* 
	 * Author: Younga Jin
	 * Date  : 03 December 2019
     * */
        static void Main(string[] args)
        {
            string[] palindromes = new string[99];
            int indexOfPalindromes = 0;
            for (int i = 0; i < palindromes.Length; i++)
            {
                palindromes[i] = "";
            }

            string userInput = "";
            while (userInput.ToLower() != "end" && indexOfPalindromes < palindromes.Length)
            {
                Console.Write("Enter characters or numbers: ");
                userInput = Console.ReadLine();
                if (IsPalindrome(userInput))
                {
                    StorePalindromes(palindromes, userInput, ref indexOfPalindromes);
                }
                DisplayResult(userInput, IsPalindrome(userInput));
            }

            DisplayListOfPalindromes(palindromes);
        }
        static bool IsPalindrome(string userInput)
        {
            bool isPalindrome = true;
            for (int i = 0; i <= userInput.Length / 2; i++)
            {
                if (userInput[i] != userInput[userInput.Length - 1 - i])
                {
                    isPalindrome = false;
                }
            }
            return isPalindrome;
        }
        static bool IsNumber(string userInput)
        {
            bool isNumber = true;
            for (int i = 0; i < userInput.Length; i++)
            {
                if(!int.TryParse(Convert.ToString(userInput[i]), out _))
                {
                    isNumber = false;
                }
            }
            return isNumber;
        }
        static void DisplayResult(string userInput, bool isPalindrome)
        {
            if (IsNumber(userInput) && isPalindrome)
            {
                Console.WriteLine($"{userInput} is a number palindrome.");
            }
            else if (isPalindrome)
            {
                Console.WriteLine($"{userInput} is a character palindrome.");
            }
            else if(userInput.ToLower() != "end")
            {
                Console.WriteLine($"{userInput} is not a palindrome.");
            }
        }
        static void DisplayListOfPalindromes(string[] palindromes)
        {
            for (int i = 0; i < palindromes.Length; i++)
            {
                if (palindromes[i] != "")
                {
                    Console.WriteLine(palindromes[i]);
                }
            }
        }
        static void StorePalindromes(string[] palindromes, string userInput, ref int indexOfPalindromes)
        {
            palindromes[indexOfPalindromes] = userInput;
            indexOfPalindromes++;
        }
    }
}
