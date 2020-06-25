using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IsPerfect
{
    // Author: Younga Jin
    // Date  : 05 December 2019
    class Program
    {
        static void Main(string[] args)
        {
            int anInteger = GetNumber();
            if (IsPerfect(anInteger))
            {
                Console.WriteLine($"{anInteger} is a perfect number.");
            }
            else
            {
                Console.WriteLine($"{anInteger} is not a perfect number.");
            }
        }
        static bool IsPerfect(int anInteger)
        {
            int sum = 0;
            bool isPerfect;

            for (int i = 1; i < anInteger; i++)
            {
                if (anInteger % i == 0)
                {
                    sum += i;
                }
            }
            if (sum == anInteger)
            {
                isPerfect = true;
            }
            else
            {
                isPerfect = false;
            }
            return isPerfect;
        }
        static int GetNumber()
        {
            int anInteger;
            bool isAnTnteger;
            do
            {
                Console.Write("Enter an integer: ");
                isAnTnteger = int.TryParse(Console.ReadLine(), out anInteger);
                if (anInteger <= 0)
                {
                    isAnTnteger = false;
                }
            } while (!isAnTnteger);
            return anInteger;
        }
    }
}
