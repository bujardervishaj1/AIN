using MathNet.Numerics.Distributions;
using System;
using System.Collections.Generic;

namespace AIN_Detyra4
{
    class Program
    {
        static readonly int SolutionLength = 8;
        static readonly int Min = 0;
        static readonly int Max = 100;
        static readonly double MutationChance = 0.5;
        static readonly double mean = 0;
        static readonly double stdDev = 100;


        static List<Double> Solution = new List<double>();
        static readonly Random random = new Random();
        static readonly MathNet.Numerics.Distributions.Normal Gaussian = new MathNet.Numerics.Distributions.Normal(mean, stdDev);
        
        static void Main(string[] args)
        {
            GenInitSolution();
            Console.WriteLine(string.Join("; ", Solution));
            MutateSolution();
            Console.WriteLine(string.Join("; ", Solution));
        }
        private static void GenInitSolution()
        {
            for (int i = 0; i < SolutionLength; i++)
            {
                
                Solution.Add(random.Next(Min,Max));

            }
        }
        private static void MutateSolution()
        {
            
            
            for (int i = 0; i< Solution.Count;i++)
            {
                var item = Solution[i];
                if (MutationChance >= random.NextDouble())
                {
                    double n;
                    do
                    {
                        n = Gaussian.Sample();
                    } while (!(Min <= (item + n) && (item + n) <= Max));
                    Solution[i] = item + n;
                }
            }
        }
    }
}
