# Data Structure and OOP - Final Project : Enhanced Budgeting app

<p align="center">
    <img src="report and resources/poster.png" alt="clone code snippet" width="445.5" height="610">
</p>

## Features
## Dependancies
• **Java Standard library**
<br>
• **No external dependancies**
<br>
• **JDK 8 or higher** (JDK11+ is recommended for best compatability and support)

## Installation & Running

1. **Download or clone this repository.**

2. **Open a terminal in the project root directory.**

3. **Compile all Java files:**
   
   On Windows (PowerShell):
   ```powershell
   javac -d bin -cp . .\OOP\*.java .\OOP\*\*.java .\DS\*.java .\DS\*\*.java .\ExpenseBuilder\*.java
   ```
   On Linux/Mac:
   ```bash
   javac -d bin -cp . ./OOP/*.java ./OOP/*/*.java ./DS/*.java ./DS/*/*.java ./ExpenseBuilder/*.java
   ```
   This will compile all source files into the `bin` directory.

4. **Run the application:**
   
   ```powershell
   java -cp bin OOP.Main
   ```
   (Replace `OOP.Main` with your actual main class if different.)

## Notes
- Make sure your sound files are in the correct location (either in the root or in the `sounds` folder).
- No external dependencies are required; only a standard Java JDK is needed.
- If you encounter issues, ensure your Java version is 8 or higher by running `java -version`.

## Data Structures Performance
### n = 1,000
#### <b>Time Taken in <u>Nano seconds</u></b>
| Data Structures | Data Generation | Insertion | Deletion | Searching | Updating | Sorting |
|-----------------|-------------------------|-----------------------------|-|-|-|-|
| ArrayList       | 416,000          |  49,047 | 20,230 | 27,667 | 48,167 | 1,230,400
| LinkedList      | 583,300	       | 59,973 | 21,400 | 12,420 | 47,023 | 1,559,800
|HashMap | 712,600 | 485,769 | 33,500 | 39,567 | 59,967 | 2,729,400|
|Stack | 607,500 | 743,200 | 419,500 | 351,772 | 368,700 | 1,621,800|
|AVL Tree | 700,200 | 95,300 | 48,900 | 758,700 | 99,067 | Already Sorted|


#### <b>Memory Usage in <u>Bytes</u></b>
| Data Structures | Data Generation | Insertion | Deletion | Searching | Updating | Sorting |
|-----------------|-------------------------|-----------------------------|-|-|-|-|
ArrayList | 74,408 | 2,882 | 0 | 0 | 2,675 | 454,760
LinkedList | 123,408 | 4,402 | 0 | 0 | 2,672 | 12,128
HashMap | 128,458 | 19,810 | 1,760 | 1,760 | 1,760 | 466,792
Stack | 71,928 | 9,792 | 6,243 | 69,490 | 6,861 | 465,328
AVL Tree | 74,520 | 2,648 | 2,648 | 2,672 | 9,648 | Already Sorted

### n = 10,000
#### <b>Time Taken in <u>Nano seconds</u></b>
| Data Structures | Data Generation | Insertion | Deletion | Searching | Updating | Sorting |
|-----------------|-------------------------|-----------------------------|-|-|-|-|
ArrayList | 1,689,600 | 68,300 | 41,663 | 21,667 | 43,367 | 10,422,300
LinkedList | 2,175,400 | 92,400 | 55,400 | 36,400 | 80,000 | 19,882,200
HashMap | 2,445,500 | 3,753,500 | 66,700 | 43,867 | 82,657 | 14,862,600
Stack | 3,583,400 | 3,868,000 | 3,987,971 | 1,670,756 | 1,513,876 | 19,451,600
AVL Tree | 1,978,800 | 145,333 | 102,928 | 699,067 | 161,467 | Already Sorted

#### <b>Memory Usage in <u>Bytes</u></b>
| Data Structures | Data Generation | Insertion | Deletion | Searching | Updating | Sorting |
|-----------------|-------------------------|-----------------------------|-|-|-|-|
ArrayList | 673,672 | 2,933 | 0 | 0 | 4,075 | 6,291,456
LinkedList | 797,480 | 9,334 | 0 | 0 | 3,291 | 5,782,656
HashMap | 1,145,893 | 196,430 | 1,760 | 1,760 | 1,760 | 198,288
Stack | 521,512 | 47,426 | 46,243 | 42,821 | 42,861 | 5,782,656
AVL Tree | 587,440 | 2,648 | 10,342 | 2,672 | 2,648 | Already Sorted|

*results of 0 is further explained in the report

## Report, Demo and Manual
For the Demo video [👉 Click here](https://drive.google.com/drive/folders/1X8SVb_UyPilcT84En5GifwhlYZ26B77g)

For Gdocs of report&nbsp; [👉 Click here](https://docs.google.com/document/d/1BkXFWzLVIb-7jPNPTuhH2XL6HZLGO4ocEI8TTf3JxcU/edit?tab=t.0)

For the Report&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [👉 Click here](report%20and%20resources/Enhanced%20Budgeting%20App%20Report.pdf)

For the Manual&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [👉 Click here](report%20and%20resources/DS%20Program%20Manual.pdf)

## Snapshots
<p align="center">
    <img src="report and resources/snap1.png" alt="clone code snippet" width="540" height="360">
    <img src="report and resources/snap2.png" alt="clone code snippet" width="540" height="360">
    <img src="report and resources/snap3.png" alt="clone code snippet" width="540" height="360">
</p>