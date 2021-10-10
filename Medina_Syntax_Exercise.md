# Create a grammar for a small language using BNF

<font size = "4">
< program > -> begin < statement_list > end </br>
< statement_list > ->  < statement > | < statatement > ; < statement_list > </br>
< statement > -> < assign > </br>
< assign > - > < var > = < expression > </br>
< var > ->  A | B | C </br>
< expression > - > < id > + < expr > | < id > * < expr > | ( < expr > ) | < id > </br>
</font>
</br>
</br>
Medina, Shaina Bess H.