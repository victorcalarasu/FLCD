Input file:

int a,b,c,max;
max := -999;
read ( a );
read ( b );
if ( a >= b and a >= c ) then :
{
max := a;
}
if ( b >= a and b >= c )
{
max := b;
}
if ( c >= a and c >= a ) {
max := a;
}
write ( max );



Symbol Table: 
-999 5
a 1
b 2
c 3
max 4


PIF:

int -1
a 1
b 2
c 3
max 4
max 4
:= -1
-999 5
read -1
( -1
a 1
) -1
read -1
( -1
b 2
) -1
if -1
( -1
a 1
>= -1
b 2
and -1
a 1
>= -1
c 3
) -1
then -1
: -1
{ -1
max 4
:= -1
a 1
} -1
if -1
( -1
b 2
>= -1
a 1
and -1
b 2
>= -1
c 3
) -1
{ -1
max 4
:= -1
b 2
} -1
if -1
( -1
c 3
>= -1
a 1
and -1
c 3
>= -1
a 1
) -1
{ -1
max 4
:= -1
a 1
} -1
write -1
( -1
max 4
) -1
