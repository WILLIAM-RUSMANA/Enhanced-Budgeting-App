public class RandomDataCategories {
    // Class to represent random data categories for expenses
    // Each category has a name, base amount, monthly trend, standard deviation, and frequency per week

    String name;
    Double baseAmount;
    Double monthlyTrend;
    Double standardDeviation;
    Double frequencyPerWeek;

    // Constructor to initialize the category with its properties
    public RandomDataCategories(String name, Double baseAmount, Double monthlyTrend, Double standardDeviation, Double frequencyPerWeek) {
        this.name = name;
        this.baseAmount = baseAmount;
        this.monthlyTrend = monthlyTrend;
        this.standardDeviation = standardDeviation;
        this.frequencyPerWeek = frequencyPerWeek;
    }

    // Getters for the properties of the category
        public String getName() {
            return name;
        }

        public Double getBaseAmount() {
            return baseAmount;
        }

        public Double getMonthlyTrend() {
            return monthlyTrend;
        }

        public Double getStandardDeviation() {
            return standardDeviation;
        }

        public Double getFrequencyPerWeek() {
            return frequencyPerWeek;
        }
    }