
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication.API.Fake;
using WebApplication.API.Models;

namespace WebApplication.API.Controllers
{ 
    [Route("api/[controller]")]
    public class UsersController:ControllerBase
    {
        private List<User> _users = FakeData.GetUsers(200);//tells how many genarates user
        [HttpGet]
       public List<User> Get()
        {
            return _users;//retun user list
        }
        [HttpGet("(id)")]//get user according to id
        public User Get(int id)
        {
            var user = _users.FirstOrDefault(x => x.Id == id);
            return user;
        }
        [HttpPost]
        public User Post([FromBody] User user) //expected user object from sended request part of the body
        {
            _users.Add(user);
            return user;
        }
    }
}
