



function fromCSV (s)
  s = s .. ','        -- ending comma
  local t = {}        -- table to collect fields
  local fieldstart = 1
  repeat
    -- next field is quoted? (start with `"'?)
    if string.find(s, '^"', fieldstart) then
      local a, c
      local i  = fieldstart
      repeat
        -- find closing quote
        a, i, c = string.find(s, '"("?)', i+1)
      until c ~= '"'    -- quote not followed by quote?
      if not i then error('unmatched "') end
      local f = string.sub(s, fieldstart+1, i-1)
      table.insert(t, (string.gsub(f, '""', '"')))
      fieldstart = string.find(s, ',', i) + 1
    else                -- unquoted; find next comma
      local nexti = string.find(s, ',', fieldstart)
      table.insert(t, string.sub(s, fieldstart, nexti-1))
      fieldstart = nexti + 1
    end
  until fieldstart > string.len(s)
  return t
end


function readAll(file)
  local f = assert(io.open(file, "rb"))
  local content = f:read("*all")
  f:close()
  return content
end


local function main()
  filename = "./out.txt";
  cont = readAll(filename);
  split = fromCSV(cont);
  print("games played: ", split[1]);
  print("player 1 average matches: ", split[2]);
  print("player 2 average matches: ", split[3]);
  print("game with the most guesses: ", split[4]);
  print("game with the least guessses: ", split[5]);
  print("average guesses per game: ", split[6]);
  print("longest guess streak: ", split[7]);
  print("player that won the most: ", split[8]);



end
main()
