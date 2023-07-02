<h1>Project - MicroJava Compiler - README</h1>
Introduction
The goal of this project is to implement a compiler for the MicroJava programming language. The compiler translates syntactically and semantically correct MicroJava programs into MicroJava bytecode that can be executed on the MicroJava virtual machine. Syntactically and semantically correct MicroJava programs are defined by the specification [MJ].

The MicroJava compiler has four main functionalities: lexical analysis, syntax analysis, semantic analysis, and code generation.

The lexical analyzer is responsible for recognizing the language lexemes and returning a set of tokens extracted from the source code, which are further processed in the syntax analysis. If a lexical error is detected during the lexical analysis, an appropriate error message should be displayed.

The syntax analyzer determines whether the extracted tokens from the program's source code can form grammatically correct sentences. During the parsing of MicroJava programs, it is necessary to enable tracking of the parsing process in a way that will be described in detail later in the document. After parsing syntactically correct MicroJava programs, the user should be notified of the success of the parsing. If the source code has syntax errors, an appropriate explanation of the detected syntax error should be issued, and the parsing should continue after error recovery.

The semantic analyzer is constructed based on the abstract syntax tree (AST) that is generated as a result of the syntax analysis. Semantic analysis is performed by implementing methods for visiting the nodes of the AST. The AST is constructed based on the grammar implemented in the previous phase. If the source code has semantic errors, an appropriate message about the detected semantic error should be displayed.

The code generator translates syntactically and semantically correct programs into executable form for the chosen MicroJava VM execution environment. Code generation is implemented in a similar way to semantic analysis, by implementing methods that visit the nodes.

Requirements Specification
I. Lexical Analysis
The following are the project requirements for implementing the lexical analyzer:

Implement a lexical analyzer (scanner) for MicroJava source programs.
The lexical analyzer is implemented by writing a .flex specification, whose format is described in the homework assignment examples on the course website.
The specification of the lexical analyzer should be placed in the file [PT]/src/spec/mjlexer.flex.
The .flex specification is transformed into the implementation of the lexer in the Java programming language using the JFlex tool available on the course website.
The generated lexer class should belong to the package rs.ac.bg.etf.pp1 within the [PT]/src directory.
The interface between the lexical analyzer and the syntax analyzer should be the standard CUP interface. For more information, refer to the mini homework example in the exercises on the course website.
The scanner accepts a file containing MicroJava source code and divides it into tokens.
A token is returned by explicitly calling the lexical analyzer (operation next_token()). The following lexical structures should be detected and processed:
Identifiers
Constants
Keywords
Operators
Comments
Lexical structures should be implemented according to the language specification [MJ§A.2p3].
The lexical analyzer should skip comments and whitespace in the program text.
Whitespace characters include: tabs (\t), newline (\r \n), space (' '), backspace (\b), form feed (\f).
In case of a lexical error, an error message should be displayed, and the program's text processing should continue.
The error message should contain the following information:
The unrecognized character sequence
The line number in the program text where the error occurred
The column (position of the first character) where the error was detected.
The use of JDK 1.8 is mandatory, as described in the examples provided.
