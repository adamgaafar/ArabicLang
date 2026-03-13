<h1>
  <img src="AlangMascut.png" width="60" align="left">
  Alang — Arabic Programming Language
  <br>
</h1>

**Alang** is an experimental programming language written **entirely in Arabic**.

It supports:

- Arabic keywords
- Arabic identifiers
- Unicode-based syntax
- A custom interpreter written in **Java**
- Grammar built using **ANTLR4**

The goal of Alang is to explore programming language design using a **fully Arabic-first syntax**, allowing programmers to write code using natural Arabic words and variables.

---

# Features

Current features include:

- Variable declaration using Arabic syntax
- Assignment statements
- Print statements
- Arithmetic operations
- Comparison operations
- `اذا` (if statements)
- `طالما` (while loops)
- Arabic variable names
- Strings and numbers
- `.alam` program files
- Command-line execution

---
# Example Program

```alang
عرف س = 10
اطبع(س)

اذا (س > 5) {
اطبع("اكبر من خمسة")
}

```
### Output:
```
10
اكبر من خمسة
```


<img src="Screenshot 2026-03-13 021041.png" width="250" align="center">

# Requirements

To run **Alang** you need:

- Java 17+
- Windows Terminal / PowerShell

No additional installation is required.

---

# Installation

Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/Alang.git

# Enter the Project Directory

```bash
cd Alang
```

---

# Add Alang to PATH

To run `alang` from anywhere, add the folder containing **Alang.bat** to your system **PATH**.

### Example Path

```
C:\Users\YourName\Documents\Projects\Alang
```

### Steps (Windows)

1. Open **Environment Variables**
2. Edit **Path**
3. Add the folder containing `Alang.bat`
4. Restart your terminal

---

# Running Alang Programs

Once the path is configured you can run programs from anywhere:

```bash
alang examples/test.alam
```

or

```bash
alang myprogram.alam
```

---

# Example

Create a file:

```
hello.alam
```

```alang
عرف س = 5
اطبع(س)
```

Run it:

```bash
alang hello.alam
```

Output:

```
5
```

---

# Terminal Encoding (Arabic Support)

If Arabic text appears incorrectly in the terminal, run:

```bash
chcp 65001
```

This enables **UTF-8 support**.

---

# Technologies Used

- Java  
- ANTLR4  
- Maven  
- Unicode Arabic identifiers  

---

# Project Goals

Alang explores the possibility of designing programming languages that use **Arabic syntax natively** instead of relying on English-based keywords.

This project demonstrates:

- Programming language grammar design  
- Parser construction  
- Interpreter implementation  
- Unicode-based syntax support  
- Command-line language execution  

---

# Future Plans

Planned improvements:

- `وإلا` (else statements)  
- Boolean values (`صح`, `خطأ`)  
- Functions  
- Return statements  
- Logical operators  
- Interactive REPL  
- Better error messages  
- Syntax highlighting support  

---

# Author

**Adam Gaafar**

Computer Engineering Student  
Software Engineer  

###### Made with ❤️ 
