Procedure userDiningProfile(history: List of Restaurant, preferences: UserPreferences) returns (List of string, Map of string to RestaurantNode)

  Define cuisineFrequency as an empty Map of string to int
  Define cuisinePriceTotal as an empty Map of string to int
  Define cuisineCount as an empty Map of string to int
  Define preferredCuisines as an empty Map of string to bool

  For each preferred in preferences.PreferredCuisines do
    Set preferredCuisines[preferred] to true
  End For

  For each restaurant in history do
    Define cuisineType as restaurant.CuisineType
    Increment cuisineFrequency[cuisineType]
    Add restaurant.PriceRange to cuisinePriceTotal[cuisineType]
    Increment cuisineCount[cuisineType]
  End For

  Define pairs as an empty List of pair with capacity equal to the size of cuisineFrequency

  For each k, v in cuisineFrequency do
    Append pair{k, v} to pairs
  End For

  Call quickSort on pairs with arguments 0 and size of pairs - 1

  Define userInterests as an empty List of string

  For each pair in pairs do
    Define cuisineType as pair.Key

    If preferredCuisines[cuisineType] is true then
      Define average as cuisinePriceTotal[cuisineType] divided by cuisineCount[cuisineType]

      If absolute value of (average - preferences.PreferredPriceRange) is less than or equal to 1000 then
        Define root as restaurantBSTs[cuisineType]

        For each restaurant in history do
          If restaurant.CuisineType is equal to cuisineType then
            Set root to the result of calling intertNode with root and restaurant as arguments
          End If
        End For

        Set restaurantBSTs[cuisineType] to root
        Append cuisineType to userInterests
      End If
    End If
  End For

  Return userInterests and restaurantBSTs
End Procedure