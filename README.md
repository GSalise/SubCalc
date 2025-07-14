This is my first time creating something and actually releasing it on Github, so bugs are to be expected. But personally, I think it should work fine for now.

**What is this: A subnet calculator**

### Functionalities:

- CIDR calculation
- VLSM calculation

**Java version required: 23 or higher**

### How to run:
java -jar SubnetCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar 
or maybe just click it  (haven't tried it in Windows or actually clicking it in the GUI, I just used the CLI)

### Limitations:
**CIDR**

- It only stops at /30, so if you were to ask for a 100 subnets in a /24 mask, it would give you 64 subnets instead since it cannot go beyond 30 (I'm gonna implement an error panel next time to inform the user about this)
- Amount of networks displayed is only limited to 1024 to prevent lag, especially with networks that reach in the millions

**VLSM**

- Number of departments is only limited to 100 ( I don't believe you're gonna calculate for more than a 100 departments)

Pictures:

CIDR Mode
![Screenshot From 2025-06-06 23-02-31](https://github.com/user-attachments/assets/15e3e642-bbeb-48c3-ae68-6ebde0f6d057)

VLSM Mode
![image](https://github.com/user-attachments/assets/0a373367-fa41-483f-9c25-06a110d22a4a)

CIDR Mode with output
![image](https://github.com/user-attachments/assets/a70347c3-3ffe-425b-ae31-d6b20c227e9c)

VLSM Mode with output
![image](https://github.com/user-attachments/assets/a2b09249-bd12-42b4-b005-68dfaf304343)
