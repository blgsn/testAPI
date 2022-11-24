using Bogus;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication.API.Models;

namespace WebApplication.API.Fake
{
    //using bogus generates fake data
    public static class FakeData
    {
        private static List<User> _users;

        public static List<User> GetUsers(int number) {
            _users = new Faker<User>()
                .RuleFor(u => u.Id, f => f.IndexFaker)
                .RuleFor(u => u.FirstName, f => f.Name.FirstName())
                .RuleFor(u => u.LastName, f => f.Name.LastName())
                .RuleFor(u => u.Address, f => f.Address.FullAddress())
                .Generate(number);
            return _users;
        }
    }
}
