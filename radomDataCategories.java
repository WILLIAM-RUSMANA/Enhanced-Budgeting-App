public class radomDataCategories {
    // Class to represent random data categories for expenses
    // Each category has a name, base amount, monthly trend, standard deviation, and frequency per week

    String name;
    Double baseAmount;
    Double monthlyTrend;
    Double standardDeviation;
    Double FrequencyperWeek;

    // Constructor to initialize the category with its properties
    public radomDataCategories(String name, Double baseAmount, Double monthlyTrend, Double standardDeviation, Double FrequencyperWeek) {
        this.name = name;
        this.baseAmount = baseAmount;
        this.monthlyTrend = monthlyTrend;
        this.standardDeviation = standardDeviation;
        this.FrequencyperWeek = FrequencyperWeek;
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

        public Double getFrequencyperWeek() {
            return FrequencyperWeek;
        }
    }