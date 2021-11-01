using System;
using System.Collections.Generic;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(Array2String(ImplementationOfCrossOver(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 6, 3, 2, 5, 4, 1 })));
        }

        private static int[] ImplementationOfCrossOver(int[] parent1, int[] parent2)
        {

            Random rnd = new Random();
            if (parent1.Length != parent2.Length)
            {
                Console.WriteLine("Length mismatch of array");
                return null;
            }

            int[] ans = new int[parent1.Length];
            int pos1 = ((int)(rnd.NextDouble() * (parent1.Length - 2))) + 1;
            int pos2 = ((int)(rnd.NextDouble() * (parent1.Length - 2))) + 1;
            if (pos2 < pos1)
            {
                int temp = pos2;
                pos2 = pos1;
                pos1 = temp;
            }
            Console.WriteLine("Positions are: " + pos1 + " and " + pos2);
            List<int> availablePool = new List<int>();
            for (int i = 0; i < parent1.Length; i++)
            {
                if (i >= pos1 && i <= pos2)
                    ans[i] = parent1[i];
                else
                    availablePool.Add(parent1[i]);
            }
            Console.WriteLine("Crossover before fill: " + Array2String(ans));
            Console.WriteLine("Numbers left to fill: " + Array2String(availablePool));
            int ansIndex = 0;
            for (int i = 0; i < parent2.Length; i++)
            {
                if (availablePool.Contains(parent2[i]))
                {
                    Console.WriteLine("Found number " + parent2[i] + " in pool " + Array2String(availablePool) + " on position: " + i);
                    ans[ansIndex] = parent2[i];
                    availablePool.Remove(parent2[i]);
                    if (ansIndex == (pos1 - 1))
                        ansIndex += pos2 - pos1 + 1;
                    ansIndex++;
                    Console.WriteLine("Solution after insert: " + Array2String(ans));
                }

            }
            return ans;
        }

        static string Array2String<T>(IEnumerable<T> list)
        {
            return "[" + string.Join(",", list) + "]";
        }
    }
}
