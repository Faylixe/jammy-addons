-- TODO : Import local function here.

-- This method aims to solve a single test case instance.
-- @param stream Input stream to read input data from.
local function solve(stream)
  -- Implement your solving method here.
end

local file = io.open(arg[1], "r");
local T = file:read("*number");
for i = 0, T do
  local result = solve(file)
  print("Case #" .. i .. ": " .. result)
end