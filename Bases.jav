public static bases(int base_Str)
_rem(“”, base_Str + “”);

public static _bases(String stem, String rem)
if rem size is 1
for (int i = 0; i < Character.getNumericValue(rem.charAt(0)); i++)
print stem + i;
else if rem is not empty
for (int i = 0; i < Character.getNumericValue(rem.charAt(0)); i++)
recurse(stem + i, rem.substring(1));